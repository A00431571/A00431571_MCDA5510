package com.mcds5510.webservice;

public class Transaction_CallProxy implements com.mcds5510.webservice.Transaction_Call {
  private String _endpoint = null;
  private com.mcds5510.webservice.Transaction_Call transaction_Call = null;
  
  public Transaction_CallProxy() {
    _initTransaction_CallProxy();
  }
  
  public Transaction_CallProxy(String endpoint) {
    _endpoint = endpoint;
    _initTransaction_CallProxy();
  }
  
  private void _initTransaction_CallProxy() {
    try {
      transaction_Call = (new com.mcds5510.webservice.Transaction_CallServiceLocator()).getTransaction_Call();
      if (transaction_Call != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)transaction_Call)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)transaction_Call)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (transaction_Call != null)
      ((javax.xml.rpc.Stub)transaction_Call)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.mcds5510.webservice.Transaction_Call getTransaction_Call() {
    if (transaction_Call == null)
      _initTransaction_CallProxy();
    return transaction_Call;
  }
  
  public java.lang.String create_Transaction(java.lang.String id, java.lang.String nameOnCard, java.lang.String cardNumber, java.lang.String unitPrice, java.lang.String quantity, java.lang.String expDate) throws java.rmi.RemoteException{
    if (transaction_Call == null)
      _initTransaction_CallProxy();
    return transaction_Call.create_Transaction(id, nameOnCard, cardNumber, unitPrice, quantity, expDate);
  }
  
  public java.lang.String update_Transaction(java.lang.String id, java.lang.String nameOnCard, java.lang.String cardNumber, java.lang.String unitPrice, java.lang.String quantity, java.lang.String expDate) throws java.rmi.RemoteException{
    if (transaction_Call == null)
      _initTransaction_CallProxy();
    return transaction_Call.update_Transaction(id, nameOnCard, cardNumber, unitPrice, quantity, expDate);
  }
  
  public java.lang.String delete_Transaction(java.lang.String id) throws java.rmi.RemoteException{
    if (transaction_Call == null)
      _initTransaction_CallProxy();
    return transaction_Call.delete_Transaction(id);
  }
  
  public java.lang.String view_Transaction(java.lang.String id) throws java.rmi.RemoteException{
    if (transaction_Call == null)
      _initTransaction_CallProxy();
    return transaction_Call.view_Transaction(id);
  }
  
  
}