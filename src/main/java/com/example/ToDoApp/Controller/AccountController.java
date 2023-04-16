package com.example.ToDoApp.Controller;

import com.example.ToDoApp.Model.Account;
import com.example.ToDoApp.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * all the endpoints live here
 * it uses the service object by dependency injection to implement the associated logic with each request
 */
@CrossOrigin(origins = "{http://localhost:4200, http://localhost:9000}", allowCredentials = "true")
@RestController
public class AccountController {
    AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    /**
     * A user should be able to create an account
     * @param account
     * @return
     */
    @PostMapping("account")
    public Account postAccount(@RequestBody Account account){ return accountService.createAccount(account); }

    //@PostMapping("account")
    //public Account loginAccount(@RequestBody Account account){ return accountService.login(account); }

    @GetMapping("account/{id}")
    public Account getAccountById(@PathVariable long id){ return accountService.getAccountById(id); }

    @PatchMapping("account/{id}")
    public Account updateAccount(@PathVariable long id, @RequestBody Account account){
        return accountService.updateAccount(id,account);
    }

    @DeleteMapping("account/{id}")
    public Account deleteAccount(@PathVariable long id){ return accountService.deleteAccount(id); }
}
