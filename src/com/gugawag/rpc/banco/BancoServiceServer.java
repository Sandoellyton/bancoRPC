package com.gugawag.rpc.banco;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class BancoServiceServer extends UnicastRemoteObject implements BancoServiceIF {

    private List<Conta> contas;
    private Map<String, Double> saldoContas;

    public BancoServiceServer() throws RemoteException {
        contas = new ArrayList<>();
        contas.add(new Conta("1", 100.0));
        contas.add(new Conta("2", 110.0));
        contas.add(new Conta("3", 120.0));

        saldoContas = new HashMap<>();
        saldoContas.put("1", 100.0);
        saldoContas.put("2", 156.0);
        saldoContas.put("3", 950.0);
    }

    @Override
    public double saldo(String conta) throws RemoteException {
        return saldoContas.get(contas);

    }

    @Override
    public int quantidadeContas() throws RemoteException {
        return contas.size();
    }

    @Override
    public void adicionarConta(String numero, Double saldo) throws RemoteException {
        contas.add(new Conta(numero, saldo));
    }

}
