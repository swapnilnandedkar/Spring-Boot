package com.bank.controllers;

import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bank.BankServices.BankService;
import com.bank.exceptions.BankNotFoundException;
import com.bank.pojos.Bank;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


@RestController
public class BankController
{
    @Autowired
    BankService bankService;


    @GetMapping
    public Bank getDafaultBank()
    {
        Bank bank = new Bank();
        bank.setBankName("HDFC Bank");
        bank.setCity("Bangalore");
        return bank;
    }



    /**
     * Hateoas ( Hypertext as the Engine of Application State )
     * provide and extra detail in response
     * Ex. In github, there are many tabs if we click on that tab it will give an
     * data like this we provide the links in response with the help of hateoas
     * @param bankName
     * @return
     */
    @GetMapping(value = "/getbank/{name}")
    public EntityModel bankName(@PathVariable("name") String bankName)
    {


       Bank bank = bankService.getBank(bankName);
       if(bank!=null)
       {
           EntityModel<Bank> entityModel = new EntityModel<>(bank);
           WebMvcLinkBuilder linkto = linkTo(methodOn(this.getClass()).findAllBanks());
           entityModel.add(linkto.withRel("All-Banks"));
           return entityModel;
       }
       throw new BankNotFoundException("Bank "+bankName+" not found");
    }

    /**
     * @Valid is use validate the data
     * Ex Bank Name = "" empty
     * then it will give an error
     *
     * @ResponseEntity  is use for status code and provide Uri
     * @param bank
     * @return
     */
    @PostMapping(value = "/savebank")
    public ResponseEntity<Object> saveBank(@Valid @RequestBody Bank bank)
    {

        bankService.saveBank(bank);
        URI location = ServletUriComponentsBuilder.
                fromCurrentRequest().
                path("/{bankName}").
                buildAndExpand(bank.getBankName())
                .toUri();

            return ResponseEntity.created(location).build();

    }

    @GetMapping("/allbanks")
    public List<Bank> findAllBanks()
    {
        return bankService.findAllBank();
    }



}
