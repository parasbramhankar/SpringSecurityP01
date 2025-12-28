/*package com.example.SpringSecurityP01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class webConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){

        httpSecurity.authorizeHttpRequests(req->
                req.requestMatchers("/updates","/contact").permitAll()
                        .anyRequest().authenticated())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());

        return httpSecurity.build();
    }
}
*/


/*
 * ================================
 * PACKAGE DECLARATION
 * ================================
 *
 * This package contains all configuration classes related to Spring Security.
 * Keeping security configuration in a separate "config" package is a good
 * practice for clean project structure.
 */
package com.example.SpringSecurityP01.config;

/*
 * ================================
 * IMPORT STATEMENTS
 * ================================
 *
 * These imports bring required Spring and Spring Security classes
 * that help us configure application security.
 */

import org.springframework.context.annotation.Bean;        // Used to create Spring-managed beans
import org.springframework.context.annotation.Configuration; // Marks this class as a configuration class
import org.springframework.security.config.Customizer;      // Provides default configurations
import org.springframework.security.config.annotation.web.builders.HttpSecurity;// Used to define security rules for HTTP requests

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// Enables Spring Security for web applications

import org.springframework.security.web.SecurityFilterChain;
// Represents the chain of security filters applied to every HTTP request


/*
 * ================================
 * @Configuration
 * ================================
 *
 * This annotation tells Spring:
 * "This class contains bean definitions and security configuration."
 *
 * Spring will scan this class at application startup
 * and apply all configurations written inside it.
 */
@Configuration


/*
 * ================================
 * @EnableWebSecurity
 * ================================
 *
 * This annotation enables Spring Security's web support.
 *
 * It:
 * - Activates the security filter chain
 * - Enables authentication & authorization mechanisms
 * - Makes Spring Security intercept all incoming HTTP requests
 */
@EnableWebSecurity
public class webConfig {

    /*
     * ==========================================================
     * @Bean : SecurityFilterChain
     * ==========================================================
     *
     * This method defines a SecurityFilterChain bean.
     *
     * SecurityFilterChain is a chain of filters that:
     * - Intercepts every incoming HTTP request
     * - Checks authentication (who are you?)
     * - Checks authorization (are you allowed?)
     *
     * Spring Security automatically looks for this bean
     * and uses it to secure the application.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){

        /*
         * ==========================================================
         * HTTP SECURITY CONFIGURATION
         * ==========================================================
         *
         * HttpSecurity is a builder object provided by Spring Security.
         *
         * It allows us to configure:
         * - Which URLs are public
         * - Which URLs need authentication
         * - Login mechanisms (form login, basic auth, etc.)
         * - Logout, CSRF, CORS, etc.
         */

        httpSecurity

                /*
                 * ======================================================
                 * AUTHORIZATION RULES
                 * ======================================================
                 *
                 * authorizeHttpRequests() is used to define
                 * authorization rules for HTTP requests.
                 *
                 * Authorization = deciding which user can access which URL.
                 */
                .authorizeHttpRequests(req ->

                        /*
                         * requestMatchers("/updates", "/contact")
                         *
                         * These URLs are PUBLIC.
                         * Anyone can access them without logging in.
                         */
                        req.requestMatchers("/updates", "/contact").permitAll()

                                /*
                                 * anyRequest().authenticated()
                                 *
                                 * This means:
                                 * - Every other URL in the application
                                 * - Requires the user to be authenticated (logged in)
                                 *
                                 * If the user is not logged in:
                                 * - Spring Security will redirect to the login page
                                 */
                                .anyRequest().authenticated()
                )

                /*
                 * ======================================================
                 * FORM LOGIN CONFIGURATION
                 * ======================================================
                 *
                 * formLogin(Customizer.withDefaults())
                 *
                 * Enables Spring Security's default login page.
                 *
                 * Features:
                 * - Username and password form
                 * - Automatically handled by Spring Security
                 * - No extra configuration required
                 */
                .formLogin(Customizer.withDefaults())

                /*
                 * ======================================================
                 * HTTP BASIC AUTHENTICATION
                 * ======================================================
                 *
                 * httpBasic(Customizer.withDefaults())
                 *
                 * Enables HTTP Basic Authentication.
                 *
                 * Mainly used for:
                 * - REST APIs
                 * - Postman testing
                 *
                 * Credentials are sent in HTTP headers.
                 */
                .httpBasic(Customizer.withDefaults());

        /*
         * ==========================================================
         * BUILDING THE SECURITY FILTER CHAIN
         * ==========================================================
         *
         * build() finalizes all the security rules
         * and returns the SecurityFilterChain object.
         *
         * Spring Security uses this filter chain
         * to secure every incoming HTTP request.
         */
        return httpSecurity.build();
    }
}
