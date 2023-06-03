package com.robson.psw4.basicAuth;

/*
@Data
@Builder
public class UserInfoUserDetails implements UserDetails {

    private String username;
    private String passwd;
    private List<GrantedAuthority> authorities;

    public UserInfoUserDetails(User user){
        this.username = user.getUserName();
        this.passwd = user.getPassword();
        this.authorities = Arrays.stream(Role.values())
                .map(s -> new SimpleGrantedAuthority(user.getRole().toString()) )
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return passwd;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

 */
