package com.bootcamp.Model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private Date invoiceDate;
    private int invoiceAmount;
    private List<Consumption> consumptionsList = new ArrayList<>();

    public Invoice(int id, Date invoiceDate) {
        this.id = id;
        this.invoiceDate = invoiceDate;
        this.invoiceAmount = calcInvoiceAmount();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public int getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(int invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public List<Consumption> getConsumptionsList() {
        return consumptionsList;
    }

    public void setConsumptionsList(List<Consumption> consumptionsList) {
        this.consumptionsList = consumptionsList;
    }

    public void addConsumptionObjList(Consumption consumption){
        consumptionsList.add(consumption);
        calcInvoiceAmount();
    }

    private int calcInvoiceAmount(){
        this.invoiceAmount = consumptionsList.stream().map(consumption -> consumption.getFee()).mapToInt(Integer::intValue).sum();
        return this.invoiceAmount;
    }
}
