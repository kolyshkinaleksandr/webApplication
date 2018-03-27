package com.kolyshkin.converter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name= "converter", eager= true)
@SessionScoped
@SuppressWarnings("serial")
public class CurrencyConverter implements Serializable, Converter {

	 final Double EUR= 33.00;
	 final Double USD= 26.50;
	 final Double GBP= 37.00;
	 final Double RUR= 0.465;

	 private Double currency;
	 private Double value;
	 private Double result;
	 private String zero;
	 private Map<String, Double> items;

	 public CurrencyConverter() {
		items= new HashMap<>();
		items.put("EURO", EUR);
		items.put("USDollar", USD);
		items.put("GBPound", GBP);
		items.put("RFRubl", RUR);
	}

	public Map<String, Double> getItems() {
		return items;
	}

	public Double getCurrency() {
		return currency;
	}

	public void setCurrency(Double currency) {
		this.currency = currency;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}

	public String getZero() {
		return zero;
	}

	public void setZero(String zero) {
		this.zero = zero;
	}

	@Override
	public String getShowConversion() {
		if (currency== null || "".equals(currency)) {
			return "";
		} else{
			String index= FacesContext.getCurrentInstance().getApplication().getResourceBundle(FacesContext.getCurrentInstance(), "label").
					      getString("inUkr");

			StringBuilder builder= new StringBuilder();
			builder.append(value);
			if (currency.equals(EUR)) {
				result= value * currency;
				String eur= " Euros";
				builder.append(eur);
			} else if(currency.equals(USD)){
				result= value * currency;
              String usd= " US dollars";
              builder.append(usd);
			} else if(currency.equals(GBP)){
				result= value * currency;
				String gbp= " GB pounds";
				builder.append(gbp);
			} else{
				result= value * currency;
				builder.append(" Rubl");
			}
         String strToFormat= String.format("%1$,.2f", result);
          builder.append(" = ");
          builder.append(strToFormat);
			builder.append(" ");
			builder.append(index);
			return builder.toString();
		}
   }

}
