package com.example.delfos;

import android.content.Context;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class Levels {


    public String level;
    public String mission;
    public String ranking;
    public String missionBox;


    Maintenance Murl = new Maintenance();


    public void misao(final Context context, String login, String password){
        String url = Murl + "CadastrarUsuario.php";

        Ion.with(context)
                .load(url)
                .setBodyParameter("level", login)
                .setBodyParameter("senha", password)
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        try {

                            String RETORNO = result.get("CADASTRO").getAsString();
                            if(RETORNO.equals("SUCESSO")){
                                Toast.makeText(context,"cadastro efetuado com Sucesso", Toast.LENGTH_LONG).show();
                            }
                            else{
                                Toast.makeText(context, "Erro ao Cadastrar", Toast.LENGTH_SHORT).show();
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
    }
}
