/**
 * Transaction_CallServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mcds5510.webservice;

public class Transaction_CallServiceLocator extends org.apache.axis.client.Service implements com.mcds5510.webservice.Transaction_CallService {

    public Transaction_CallServiceLocator() {
    }


    public Transaction_CallServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public Transaction_CallServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Transaction_Call
    private java.lang.String Transaction_Call_address = "http://localhost:8080/Assignment3/services/Transaction_Call";

    public java.lang.String getTransaction_CallAddress() {
        return Transaction_Call_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String Transaction_CallWSDDServiceName = "Transaction_Call";

    public java.lang.String getTransaction_CallWSDDServiceName() {
        return Transaction_CallWSDDServiceName;
    }

    public void setTransaction_CallWSDDServiceName(java.lang.String name) {
        Transaction_CallWSDDServiceName = name;
    }

    public com.mcds5510.webservice.Transaction_Call getTransaction_Call() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Transaction_Call_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTransaction_Call(endpoint);
    }

    public com.mcds5510.webservice.Transaction_Call getTransaction_Call(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.mcds5510.webservice.Transaction_CallSoapBindingStub _stub = new com.mcds5510.webservice.Transaction_CallSoapBindingStub(portAddress, this);
            _stub.setPortName(getTransaction_CallWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTransaction_CallEndpointAddress(java.lang.String address) {
        Transaction_Call_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.mcds5510.webservice.Transaction_Call.class.isAssignableFrom(serviceEndpointInterface)) {
                com.mcds5510.webservice.Transaction_CallSoapBindingStub _stub = new com.mcds5510.webservice.Transaction_CallSoapBindingStub(new java.net.URL(Transaction_Call_address), this);
                _stub.setPortName(getTransaction_CallWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Transaction_Call".equals(inputPortName)) {
            return getTransaction_Call();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservice.mcds5510.com", "Transaction_CallService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservice.mcds5510.com", "Transaction_Call"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Transaction_Call".equals(portName)) {
            setTransaction_CallEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
