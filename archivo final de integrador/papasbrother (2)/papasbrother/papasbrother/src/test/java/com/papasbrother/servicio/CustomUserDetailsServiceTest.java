package com.papasbrother.servicio;

import com.papasbrother.modelo.User;
import com.papasbrother.repositorio.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.util.Optional;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CustomUserDetailsServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private CustomUserDetailsService customUserDetailsService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLoadUserByUsernameFound() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("pass");
        user.setEnabled(true);
        Set<com.papasbrother.modelo.Role> roles = new java.util.HashSet<>();
        roles.add(new com.papasbrother.modelo.Role("ROLE_ADMIN"));
        user.setRoles(roles);
        when(userRepository.findByUsername("admin")).thenReturn(Optional.of(user));
        UserDetails details = customUserDetailsService.loadUserByUsername("admin");
        assertEquals("admin", details.getUsername());
        assertEquals("pass", details.getPassword());
        assertTrue(details.isEnabled());
    }

    @Test
    public void testLoadUserByUsernameNotFound() {
        when(userRepository.findByUsername("noone")).thenReturn(Optional.empty());
        assertThrows(UsernameNotFoundException.class, () -> customUserDetailsService.loadUserByUsername("noone"));
    }
}
