package com.geektrust.backend.entites;

public class MetroCard {
    private final String cardId;
    private Integer balance;
    private JourneyType journeyType;

  public MetroCard(String cardId,Integer balance){
      this.cardId=cardId;
      this.balance=balance;
      journeyType=JourneyType.SINGLE;
  }

    public void toggleJourneyType() {
        if (journeyType == JourneyType.SINGLE) {
            journeyType = JourneyType.RETURN;
        } else {
            journeyType = JourneyType.SINGLE;
        }
    }

    public JourneyType getJourneyType() {
        return journeyType;
    }

    public String getCardId() {
        return cardId;
    }

    public Integer getBalance() {
        return balance;
    }

    public void addBalance(Integer balance){
      this.balance+=balance;
    }

    public void deductBalance(Integer balance) {
        this.balance= this.balance-balance;
    }

}
