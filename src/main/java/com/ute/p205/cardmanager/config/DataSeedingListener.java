package com.ute.p205.cardmanager.config;

import com.ute.p205.cardmanager.model.*;
import com.ute.p205.cardmanager.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

@Component
public class DataSeedingListener implements CommandLineRunner {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private CustomerStatusRepository CustomerStatusRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerInfoRepository customerInfoRepository;

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountStatusRepository accountStatusRepository;
    @Autowired
    private AccountTypeRepository accountTypeRepository;

    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private CardTypeRepository cardTypeRepository;
    @Autowired
    private CardStatusRepository cardStatusRepository;
    @Autowired
    private LimitCreditCardRepository limitCreditCardRepository;

    @Autowired
    private TypeOfMoneyRepository typeOfMoneyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Role
        if (roleRepository.findByRole("ROLE_ADMIN") == null) {
            roleRepository.save(new Role("ROLE_ADMIN"));
        }
        if (roleRepository.findByRole("ROLE_MEMBER") == null) {
            roleRepository.save(new Role("ROLE_MEMBER"));
        }
        // Customer Status
        if (CustomerStatusRepository.findByStatus("block") == null) {
            CustomerStatusRepository.save(new CustomerStatus("block"));
        }
        if (CustomerStatusRepository.findByStatus("active") == null) {
            CustomerStatusRepository.save(new CustomerStatus("active"));
        }
        // Type of money
        if (typeOfMoneyRepository.findTypeOfMoneyByName("VND") == null){
            typeOfMoneyRepository.save(new TypeOfMoney("VND", "Viet Nam Dong"));
        }
        if (typeOfMoneyRepository.findTypeOfMoneyByName("USD") == null){
            typeOfMoneyRepository.save(new TypeOfMoney("USD", "United States Dollar"));
        }
        if(accountStatusRepository.findByName("Active") == null)
            accountStatusRepository.save(new AccountStatus("Active"));
        if (accountTypeRepository.findByName("Basic") == null)
            accountTypeRepository.save(new AccountType("Basic"));
        // Bank Account
        String urlAcc = "accountNumber.txt";
        FileInputStream fileInputStream = new FileInputStream(urlAcc);
        Scanner scanner = new Scanner(fileInputStream);

        try {
            AccountType accountType = accountTypeRepository.findByName("Basic");
            AccountStatus accountStatus = accountStatusRepository.findByName("Active");
            while (scanner.hasNextLine()) {
                String number = scanner.nextLine();
                String date = scanner.nextLine();
                String money = scanner.nextLine();
                if(accountRepository.findByNumber(number) == null){
                    Account account = new Account(number, date, money);
                    account.setAccountType(accountType);
                    account.setAccountStatus(accountStatus);
                    accountRepository.save(account);
                }
            }
        } finally {
            try {
                scanner.close();
                fileInputStream.close();
            } catch (IOException ex) {
                System.out.print(ex);
            }
        }
        // Type of card
        if (cardTypeRepository.findByName("Visa_Credit") == null)
            cardTypeRepository.save(new CardType("Visa_Credit"));
        if (cardTypeRepository.findByName("Visa_Debit") == null)
            cardTypeRepository.save(new CardType("Visa_Debit"));
        if (cardTypeRepository.findByName("Local_Credit") == null)
            cardTypeRepository.save(new CardType("Local_Credit"));
        if (cardTypeRepository.findByName("Local_Debit") == null)
            cardTypeRepository.save(new CardType("Local_Debit"));
        // Status of Card
        if (cardStatusRepository.findByName("Active") == null)
            cardStatusRepository.save(new CardStatus("Active"));
        if (cardStatusRepository.findByName("Block") == null)
            cardStatusRepository.save(new CardStatus("Block"));
        if (cardStatusRepository.findByName("Linked") == null)
            cardStatusRepository.save(new CardStatus("Linked"));
        if (cardStatusRepository.findByName("NotLink") == null)
            cardStatusRepository.save(new CardStatus("NotLink"));
        // Limit of credit card
        if (limitCreditCardRepository.findByLimitMoney("10000000") == null) {
            LimitCreditCard limitCreditCard = new LimitCreditCard("10000000");
            TypeOfMoney typeOfMoney = typeOfMoneyRepository.findTypeOfMoneyByName("VND");
            limitCreditCard.setTypeOfMoney(typeOfMoney);
            limitCreditCardRepository.save(limitCreditCard);
        }
        if (limitCreditCardRepository.findByLimitMoney("20000000") == null) {
            LimitCreditCard limitCreditCard = new LimitCreditCard("20000000");
            TypeOfMoney typeOfMoney = typeOfMoneyRepository.findTypeOfMoneyByName("VND");
            limitCreditCard.setTypeOfMoney(typeOfMoney);
            limitCreditCardRepository.save(limitCreditCard);
        }
        if (limitCreditCardRepository.findByLimitMoney("50000000") == null) {
            LimitCreditCard limitCreditCard = new LimitCreditCard("50000000");
            TypeOfMoney typeOfMoney = typeOfMoneyRepository.findTypeOfMoneyByName("VND");
            limitCreditCard.setTypeOfMoney(typeOfMoney);
            limitCreditCardRepository.save(limitCreditCard);
        }
        if (limitCreditCardRepository.findByLimitMoney("100000000") == null) {
            LimitCreditCard limitCreditCard = new LimitCreditCard("100000000");
            TypeOfMoney typeOfMoney = typeOfMoneyRepository.findTypeOfMoneyByName("VND");
            limitCreditCard.setTypeOfMoney(typeOfMoney);
            limitCreditCardRepository.save(limitCreditCard);
        }
        // list visa card
        String urlVisa = "visaFull.txt";
        FileInputStream fileInputStreamVisa = new FileInputStream(urlVisa);
        Scanner scanner2 = new Scanner(fileInputStreamVisa);

        try {
            CardType cardType = cardTypeRepository.findByName("Visa_Credit");
            CardType cardType2 = cardTypeRepository.findByName("Visa_Debit");
            CardStatus cardStatus = cardStatusRepository.findByName("NotLink");
            LimitCreditCard limitCreditCard = limitCreditCardRepository.findByLimitMoney("10000000");
            int i = 0;
            while (scanner2.hasNextLine()) {
                String number = scanner2.nextLine();
                String validate = scanner2.nextLine();
                String exdate = scanner2.nextLine();
                if(cardRepository.findCardByNumber(number) == null){
                    Card card = new Card(number, validate, exdate);
//                    if (i < 50)
//                       card.setCardType(cardType);
//                    else
//                        card.setCardType(cardType2);
                    card.setCardType(i++ < 50 ? cardType:cardType2);
                    card.setCardStatus(cardStatus);
                    card.setLimitCreditCard(limitCreditCard);
                    cardRepository.save(card);
                }
            }
        } finally {
            try {
                scanner2.close();
                fileInputStream.close();
            } catch (IOException ex) {
                System.out.print(ex);
            }
        }
        // Customer
        if (customerRepository.findByUsername("admin") == null) {
            Customer admin = new Customer();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("12345678"));
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByRole("ROLE_ADMIN"));
            roles.add(roleRepository.findByRole("ROLE_MEMBER"));
            admin.setSysRoles(roles);
            CustomerStatus customerStatus = CustomerStatusRepository.findByStatus("active");
            admin.setCustomerStatus(customerStatus);
            CustomerInfo customerInfo = new CustomerInfo("Dat", "Nguyen", "A1-14-02, Hiep Binh Chanh, Thu Duc"
                    , "241647708", "2014-05-02", " ", "0989542812","datnguyen2847@gmail.com");
            customerInfo.setCustomer(admin);
            admin.setCustomerInfo(customerInfo);
            customerRepository.save(admin);
        }
    }
}