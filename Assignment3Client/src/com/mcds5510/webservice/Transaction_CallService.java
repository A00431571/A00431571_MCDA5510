/**
 * Transaction_CallService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mcds5510.webservice;

public interface Transaction_CallService extends javax.xml.rpc.Service {
    public java.lang.String getTransaction_CallAddress();

    public com.mcds5510.webservice.Transaction_Call getTransaction_Call() throws javax.xml.rpc.ServiceException;

    public com.mcds5510.webservice.Transaction_Call getTransaction_Call(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
