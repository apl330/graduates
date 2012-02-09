package org.projects.graduates.domain;


import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

import com.dayatang.domain.AbstractEntity;
import com.dayatang.domain.QuerySettings;

@Entity
@Table(name = "proj_users")
public class User extends AbstractEntity implements UserDetails, CredentialsContainer  {
    //~ Instance fields ================================================================================================

	private static final long serialVersionUID = -5139547379510674278L;

	private static final String DEFAULT_PASSWORD = "123456";

	@Column(name = "username", unique = true, nullable = false)
	private String username;
	
    private String password;
    
    @Column(name = "account_non_expired")
    private boolean accountNonExpired = true;
    
    @Column(name = "account_non_locked")
    private boolean accountNonLocked = true;

    @Column(name = "credentials_non_expired")
    private boolean credentialsNonExpired = true;

    private boolean enabled = true;
    
    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role_name")
    private Set<Role> roles = new HashSet<Role>();

    //~ Constructors ===================================================================================================

    User() {
	}
    
    

    public User(String username) {
		this.username = username;
		password = DEFAULT_PASSWORD;
	}



	/**
     * Construct the <code>User</code> with the details required by
     * {@link org.springframework.security.authentication.dao.DaoAuthenticationProvider}.
     *
     * @param username the username presented to the
     *        <code>DaoAuthenticationProvider</code>
     * @param password the password that should be presented to the
     *        <code>DaoAuthenticationProvider</code>
     * @param enabled set to <code>true</code> if the user is enabled
     * @param accountNonExpired set to <code>true</code> if the account has not
     *        expired
     * @param credentialsNonExpired set to <code>true</code> if the credentials
     *        have not expired
     * @param accountNonLocked set to <code>true</code> if the account is not
     *        locked
     * @param authorities the authorities that should be granted to the caller
     *        if they presented the correct username and password and the user
     *        is enabled. Not null.
     *
     * @throws IllegalArgumentException if a <code>null</code> value was passed
     *         either as a parameter or as an element in the
     *         <code>GrantedAuthority</code> collection
     */
    public User(String username, String password, boolean enabled, boolean accountNonExpired,
            boolean credentialsNonExpired, boolean accountNonLocked, Set<Role> roles) {

        if (((username == null) || "".equals(username)) || (password == null)) {
            throw new IllegalArgumentException("Cannot pass null or empty values to constructor");
        }

        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.accountNonExpired = accountNonExpired;
        this.credentialsNonExpired = credentialsNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.roles = Collections.unmodifiableSet(roles);
    }

    //~ Methods ========================================================================================================

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public void addRoles(Role... roles) {
		for (Role role: roles) {
			this.roles.add(role);
		}
	}

	public void removeRoles(Role... roles) {
		for (Role role: roles) {
			this.roles.remove(role);
		}
	}

	public Collection<GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> results = new HashSet<GrantedAuthority>();
		for (Role role : roles) {
			results.add(new GrantedAuthorityImpl(role.name()));
		}
        return results;
    }

	public void eraseCredentials() {
        password = null;
    }

    /**
     * Returns {@code true} if the supplied object is a {@code User} instance with the
     * same {@code username} value.
     * <p>
     * In other words, the objects are equal if they have the same username, representing the
     * same principal.
     */
    @Override
    public boolean equals(Object rhs) {
        if (rhs instanceof User) {
            return username.equals(((User) rhs).username);
        }
        return false;
    }

    /**
     * Returns the hashcode of the {@code username}.
     */
    @Override
    public int hashCode() {
        return username.hashCode();
    }

    @Override
    public String toString() {
    	return username;
    }

	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */
	public static User getByUsername(String username) {
		return getRepository().getSingleResult(QuerySettings.create(User.class).eq("username", username));
	}
	
	/**
	 * 判断用户名是否存在
	 * @param username
	 * @return
	 */
	public static boolean judgeUserExistByUsername(String username){
		if(getRepository().find(QuerySettings.create(User.class).eq("username", username)).size()>0)
		{
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 登录验证
	 * @param username
	 * @param password
	 * @return
	 */
	public static User loginChecking(String username,String password){
		return getRepository().getSingleResult(QuerySettings.create(User.class).eq("username", username).eq("password", password));
	}
	
}
