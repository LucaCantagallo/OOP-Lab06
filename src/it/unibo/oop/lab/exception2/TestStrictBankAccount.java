package it.unibo.oop.lab.exception2;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * JUnit test to test
 * {@link StrictBankAccount}.
 * 
 */
public final class TestStrictBankAccount {

    private static final double AMOUNT_INIT = 10000;
    private static final int N_MAX_TRANSACTIONS = 10;
    

	/**
     * Used to test Exceptions on {@link StrictBankAccount}.
     */
    @Test
    public void testBankOperations() {
        /*
         * 1) Creare due StrictBankAccountImpl assegnati a due AccountHolder a
         * scelta, con ammontare iniziale pari a 10000 e nMaxATMTransactions=10
         */
    	final AccountHolder aH1 = new AccountHolder("Ham", "Burger", 70);
        final AccountHolder aH2 = new AccountHolder("Coca", "Cola", 35);
        final StrictBankAccount sBA1 = new StrictBankAccount(aH1.getUserID(), AMOUNT_INIT, N_MAX_TRANSACTIONS);
        final StrictBankAccount sBA2 = new StrictBankAccount(aH2.getUserID(), AMOUNT_INIT, N_MAX_TRANSACTIONS);
    	
    	
    	
         /* 2) Effetture un numero di operazioni a piacere per verificare che le
         * eccezioni create vengano lanciate soltanto quando opportuno, cioè in
         * presenza di un id utente errato, oppure al superamento del numero di
         * operazioni ATM gratuite.
         */
       try { 
        sBA1.deposit(aH1.getUserID(), 400); //okay
       } catch (final WrongAccountHolderException e){
    	   fail("Here there must be no exceptions!");
       }
       
       try { 
           sBA2.deposit(aH1.getUserID(), 400); //wrong user
           
           fail("Here there must be an exception!");
          } catch (final WrongAccountHolderException e){
        	  System.out.println("EXCEPTION!! You selected a wrong user: " + e.getMessage());
        	  assertTrue(e.getMessage().contains("userID = " + aH1.getUserID()));
          }
       
       try {
    	   sBA1.withdrawFromATM(aH1.getUserID(), 500); 
       } catch (final TransactionsOverQuotaException e) {
    	   fail("This should be full of exceptions!");
       } 
       
       try {
    	   for(int i = 0; i <= N_MAX_TRANSACTIONS; i++) {
    		   sBA2.depositFromATM(aH2.getUserID(), 1);
    	   }
    	   fail("It should be without any exceptions!");
       } catch (final TransactionsOverQuotaException e) {
    	   System.out.println("EXCEPTION!! Transactions are over the maximum quota: " + e);
       }

       try {
    	   sBA1.computeManagementFees(aH1.getUserID());
       } catch (final WrongAccountHolderException | 
    		   		TransactionsOverQuotaException|
    		   		NotEnoughFoundsException e) {
    	   fail("There must be no exceptions!");
       }
       
       try {
    	   for(int i = 0; i < AMOUNT_INIT; i++) {
    		   sBA1.computeManagementFees(aH1.getUserID());
    	   }
    	   fail("There must be an exceptions!");
       } catch (final TransactionsOverQuotaException e) {
    	   fail("It's not a Transaction's exception!");
       } catch (final NotEnoughFoundsException e) {
    	   System.out.println("EXCEPTION!! There isn't enough founds: " + e.getMessage());
       }     
    }
}


