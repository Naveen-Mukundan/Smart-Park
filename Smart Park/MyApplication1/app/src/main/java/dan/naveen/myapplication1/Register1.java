package dan.naveen.myapplication1;


public class Register1 {

    private String _first_name;

    private String _user_name;
    private String _last_name,_phone,_car_number;
   private int _Id;
    private String _car_comp,_car_comp1,_email,_pass;

    public Register1() {

    }

    public int get_Id() {
        return _Id;
    }

    public void set_Id(int id) {
        this._Id = id;
    }

    public Register1(String first_name,String last_name,String phone,String username,String car_no,String cc,String cc1,String mail,String password) {


        this._first_name =first_name;
        this._last_name=last_name;
        this._phone=phone;
        this._user_name=username;
        this._car_number=car_no;
        this._car_comp=cc;
        this._car_comp1=cc1;
        this._email=mail;
        this._pass=password;
    }




    public void set_user_name(String _user_name) {
        this._user_name = _user_name;
    }

    public void set_first_name(String _product_name) {
        this._first_name = _product_name;
    }



    public void set_last_name(String last_name) {
        this._last_name = last_name;
    }

    public void set_phone(String phone) {
        this._phone = phone;
    }

    public void set_car_number(String car_number) {
        this._car_number = car_number;
    }

    public void set_car_comp1(String car_comp1) {
        this._car_comp1 = car_comp1;
    }

    public void set_email(String email) {
        this._email = email;
    }

    public void set_car_comp(String car_comp) {
        this._car_comp = car_comp;
    }

    public void set_pass(String pass) {
        this._pass = pass;
    }



    public String get_first_name() {
        return _first_name;
    }

    public String get_last_name() {
        return _last_name;
    }

   public String get_phone() {
        return _phone;
    }

    public String get_car_number() {
        return _car_number;
    }

    public String get_car_comp() {
        return _car_comp;
    }

    public String get_car_comp1() {
        return _car_comp1;
    }

    public String get_email() {
        return _email;
    }

    public String get_pass() {
        return _pass;
    }

    public String get_user_name() {  return _user_name; }
}

