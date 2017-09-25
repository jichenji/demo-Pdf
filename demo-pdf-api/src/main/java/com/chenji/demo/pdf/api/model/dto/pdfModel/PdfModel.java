package com.chenji.demo.pdf.api.model.dto.pdfModel;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by chenji on 2017/8/30.
 */
public class PdfModel {
    private String listingId ;
    private String userName ;
    private int repaymentType ;
    private BigDecimal amount ;
    private String monthlyPayment ;
    private String  listingStartTime ;
    private List<PdfModelDetail> pdfModelDetails;
    private int months ;
    private String poundage ;
    private String poundagePerMonth ;
    private String valueAddedFee ;
    private String valueAddedFeePerMonth ;
    private int feePeriodNum ;
    private String totalPoundage ;

    public String getListingId() {
        return listingId;
    }

    public void setListingId(String listingId) {
        this.listingId = listingId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getRepaymentType() {
        return repaymentType;
    }

    public void setRepaymentType(int repaymentType) {
        this.repaymentType = repaymentType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(String monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public String getListingStartTime() {
        return listingStartTime;
    }

    public void setListingStartTime(String listingStartTime) {
        this.listingStartTime = listingStartTime;
    }

    public List<PdfModelDetail> getPdfModelDetails() {
        return pdfModelDetails;
    }

    public void setPdfModelDetails(List<PdfModelDetail> pdfModelDetails) {
        this.pdfModelDetails = pdfModelDetails;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }


    public String getPoundage() {
        return poundage;
    }

    public void setPoundage(String poundage) {
        this.poundage = poundage;
    }

    public String getPoundagePerMonth() {
        return poundagePerMonth;
    }

    public void setPoundagePerMonth(String poundagePerMonth) {
        this.poundagePerMonth = poundagePerMonth;
    }

    public String getValueAddedFee() {
        return valueAddedFee;
    }

    public void setValueAddedFee(String valueAddedFee) {
        this.valueAddedFee = valueAddedFee;
    }

    public String getValueAddedFeePerMonth() {
        return valueAddedFeePerMonth;
    }

    public void setValueAddedFeePerMonth(String valueAddedFeePerMonth) {
        this.valueAddedFeePerMonth = valueAddedFeePerMonth;
    }

    public int getFeePeriodNum() {
        return feePeriodNum;
    }

    public void setFeePeriodNum(int feePeriodNum) {
        this.feePeriodNum = feePeriodNum;
    }

    public String getTotalPoundage() {
        return totalPoundage;
    }

    public void setTotalPoundage(String totalPoundage) {
        this.totalPoundage = totalPoundage;
    }
}
