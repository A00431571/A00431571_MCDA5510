/**
 * Transaction_Call.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mcds5510.webservice;

public interface Transaction_Call extends java.rmi.Remote {
    public java.lang.String create_Transaction(java.lang.String id, java.lang.String nameOnCard, java.lang.String cardNumber, java.lang.String unitPrice, java.lang.String quantity, java.lang.String expDate) throws java.rmi.RemoteException;
    public java.lang.String update_Transaction(java.lang.String id, java.lang.String nameOnCard, java.lang.String cardNumber, java.lang.String unitPrice, java.lang.String quantity, java.lang.String expDate) throws java.rmi.RemoteException;
    public java.lang.String delete_Transaction(java.lang.String id) throws java.rmi.RemoteException;
    public java.lang.String view_Transaction(java.lang.String id) throws java.rmi.RemoteException;
}
