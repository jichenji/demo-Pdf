package com.chenji.demo.pdf.api.model.dto.pdfModel;

import java.math.BigDecimal;

/**
 * Created by chenji on 2017/8/30.
 */
public class PdfModelDetail {
    private Integer lendId;
    private String userName ;

    private BigDecimal bidAmount ;

    private String listingMonth ;

    private String listingCurrentRate ;

    private String listingStartDate ;

    private String listingEndDate ;

    //月还款日
    private String monthRepaymentDay ;

    //月还款金额
    private String monthRepaymentMoney ;

    public Integer getLendId() {
        return lendId;
    }

    public void setLendId(Integer lendId) {
        this.lendId = lendId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public BigDecimal getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(BigDecimal bidAmount) {
        this.bidAmount = bidAmount;
    }

    public String getListingMonth() {
        return listingMonth;
    }

    public void setListingMonth(String listingMonth) {
        this.listingMonth = listingMonth;
    }

    public String getListingCurrentRate() {
        return listingCurrentRate;
    }

    public void setListingCurrentRate(String listingCurrentRate) {
        this.listingCurrentRate = listingCurrentRate;
    }

    public String getListingStartDate() {
        return listingStartDate;
    }

    public void setListingStartDate(String listingStartDate) {
        this.listingStartDate = listingStartDate;
    }

    public String getListingEndDate() {
        return listingEndDate;
    }

    public void setListingEndDate(String listingEndDate) {
        this.listingEndDate = listingEndDate;
    }

    public String getMonthRepaymentDay() {
        return monthRepaymentDay;
    }

    public void setMonthRepaymentDay(String monthRepaymentDay) {
        this.monthRepaymentDay = monthRepaymentDay;
    }

    public String getMonthRepaymentMoney() {
        return monthRepaymentMoney;
    }

    public void setMonthRepaymentMoney(String monthRepaymentMoney) {
        this.monthRepaymentMoney = monthRepaymentMoney;
    }
}
