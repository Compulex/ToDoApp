package com.example.ToDoApp.Repository;

import com.example.ToDoApp.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * JpaRepository has the basic query methods find by id, find all, save, delete
 */
public interface AccountRepository extends JpaRepository<Account,Long> {
    /**
     * finds the account by username for the purpose of logging in verifying it
     * @param username username of Account
     * @return the matching Account object
     */
    @Query("FROM Account WHERE username = :username")
    Account findByUsername(@Param("username")String username);
}
