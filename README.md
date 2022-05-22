<h1 align="center">ATM simulator</h1>

---

ATM console simulator.      
Use numbers to navigate into the program.       
![img_1.png](images/img_1.png)

##Functions

###1. Login
   
Enter the card number and pin code.        
(The data is in the file "src/java/com/lavrus/atm/resources/verifiedCards.properties").     
![img.png](images/img.png)

###2. Deposit money:

To deposit money enter the short currency code, specify denomination and integer count of money.     
The funds will be added to your account.        
![img_2.png](images/img_2.png)

###3. Info:

You can check your account balance.     
![img_4.png](images/img_4.png)

###4. Withdraw:

To withdraw cash, specify the currency code, then the desired amount.       
If there are enough funds in the account in the specified currency, the operation will be completed successfully.       
![img_5.png](images/img_5.png)     
Otherwise, a notification will be displayed about the absence of the specified amount,      
and you will be asked to enter it again.        
![img_6.png](images/img_6.png)

###5. Exit:

To terminate the program enter "exit" at any time of it's work.     
![img_7.png](images/img_7.png)
