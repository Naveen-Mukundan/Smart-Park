package com.system;


public class Register {
    private String _Username,_Id,_Amt,_pc;
    private String _palo,_hr,_min,_status;



    public Register(String id,String username,String amt,String pc)
    {
        this._Id=id;
        this._Username=username;
        this._Amt=amt;
        this._pc=pc;
    }
    public String get_Id() {
        return _Id;
    }

    public void set_Id(String id) {
        this._Id = id;
    }

    public String  get_Username() {
        return _Username;
    }

    public void set_Username(String username) {
        this._Username = username;
    }

    public String get_Amt() {
        return _Amt;
    }

    public void set_Amt(String amt) {
        this._Amt = amt;
    }

    public String get_pc() {
        return _pc;
    }

    public void set_pc(String pc) {
        this._pc = pc;
    }

    public String get_palo() {
        return _palo;
    }

    public void set_palo(String olo) {
        this._palo = olo;
    }

    public String get_hrr() {
        return _hr;
    }

    public void set_hr(String hour) {
        this._hr = hour;
    }
    public String get_min() {
        return _min;
    }

    public void set_min(String min) {
        this._min = min;
    }

    public String get_status() {
        return _status;
    }

    public void set_status(String status) {
        this._status = status;
    }

}
