package registerserenity.models;


public class TransactionModel {
    
       private String transactionDate;
        private String transactionAmount;
        private String transactionDescription;

        public String getTransactionDate() {
            return transactionDate;
        }
        public void setTransactionDate(String transactionDate) {
            this.transactionDate = transactionDate;
        }
        public String getTransactionAmount() {
            return transactionAmount;
        }
        public void setTransactionAmount(String transactionAmount) {
            this.transactionAmount = transactionAmount;
        }
        public String getTransactionDescription() {
            return transactionDescription;
        }
        public void setTransactionDescription(String transactionDescription) {
            this.transactionDescription = transactionDescription;
        }


}
