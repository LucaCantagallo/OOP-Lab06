package it.unibo.oop.lab.exception2;

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
    	final AccountHolder aH1 = new AccountHolder("Naruto", "Uzumaki", 70);
        final AccountHolder aH2 = new AccountHolder("Sasuke", "Uchiha", 35);
        final StrictBankAccount sBA1 = new StrictBankAccount(aH1.getUserID(), AMOUNT_INIT, N_MAX_TRANSACTIONS);
        final StrictBankAccount sBA2 = new StrictBankAccount(aH2.getUserID(), AMOUNT_INIT, N_MAX_TRANSACTIONS);
    	
    	
    	
         /* 2) Effetture un numero di operazioni a piacere per verificare che le
         * eccezioni create vengano lanciate soltanto quando opportuno, cioè in
         * presenza di un id utente errato, oppure al superamento del numero di
         * operazioni ATM gratuite.
         */
    }
}
