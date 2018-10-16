package convertx.ic.ufmt.br.convertx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonArray;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ViewHolder mViewHolder = new ViewHolder();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.getSpinner1 = findViewById(R.id.spinner1);
        this.mViewHolder.getSpinner2 = findViewById(R.id.spinner2);
        this.mViewHolder.getImage = findViewById(R.id.image_troca);
        this.mViewHolder.textoCalcular = findViewById(R.id.edit_valor);
        this.mViewHolder.btn_converter = findViewById(R.id.button_converter);
        this.mViewHolder.setValor = findViewById(R.id.seta_valor);
        this.mViewHolder.teste = findViewById(R.id.teste);

        this.mViewHolder.btn_converter.setOnClickListener(this);
        this.mViewHolder.getImage.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.button_converter){
            HTTPService connection = new HTTPService();
            try {
                Moeda retorno = connection.execute().get();
                int pos1 = this.mViewHolder.getSpinner1.getSelectedItemPosition();
                int pos2 = this.mViewHolder.getSpinner2.getSelectedItemPosition();
                Double valor = Double.valueOf(this.mViewHolder.textoCalcular.getText().toString());
                double moeda1, moeda2;
                moeda1 = 9999999;
                moeda2 = 1;
                if (pos1 == 0){
                    moeda1 = retorno.rates.getBRL();
                } else if (pos1 == 1){
                    moeda1 = retorno.rates.getUSD();
                } else if (pos1 == 2){
                    moeda1 = retorno.rates.getEUR();
                } else if (pos1 == 3){
                    moeda1 = retorno.rates.getGBP();
                } else if (pos1 == 4){
                    moeda1 = retorno.rates.getCHF();
                } else if (pos1 == 5){
                    moeda1 = retorno.rates.getJPY();
                } else if (pos1 == 6){
                    moeda1 = retorno.rates.getAUD();
                } else if (pos1 == 7){
                    moeda1 = retorno.rates.getARS();
                } else if (pos1 == 8){
                    moeda1 = retorno.rates.getCLP();
                } else if (pos1 == 9){
                    moeda1 = retorno.rates.getCAD();
                }

                if (pos2 == 0){
                    moeda2 = retorno.rates.getBRL();
                } else if (pos2 == 1){
                    moeda2 = retorno.rates.getUSD();
                } else if (pos2 == 2){
                    moeda2 = retorno.rates.getEUR();
                } else if (pos2 == 3){
                    moeda2 = retorno.rates.getGBP();
                } else if (pos2 == 4){
                    moeda2 = retorno.rates.getCHF();
                } else if (pos2 == 5){
                    moeda2 = retorno.rates.getJPY();
                } else if (pos2 == 6){
                    moeda2 = retorno.rates.getAUD();
                } else if (pos2 == 7){
                    moeda2 = retorno.rates.getARS();
                } else if (pos2 == 8){
                    moeda2 = retorno.rates.getCLP();
                } else if (pos2 == 9){
                    moeda2 = retorno.rates.getCAD();
                }

                double resultado = moeda2/moeda1*valor;
                this.mViewHolder.setValor.setText(String.format("%.2f", resultado));

                this.mViewHolder.teste.setText(retorno.date);
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //Moeda retorno = connection.execute().get();
            // this.mViewHolder.teste.setText(retorno.toString());
        }else if(id == R.id.image_troca){
            int aux;
            aux = this.mViewHolder.getSpinner1.getSelectedItemPosition();
            this.mViewHolder.getSpinner1.setSelection(this.mViewHolder.getSpinner2.getSelectedItemPosition());
            this.mViewHolder.getSpinner2.setSelection(aux);
            Double valor1 = Double.valueOf(this.mViewHolder.textoCalcular.getText().toString());
            Double valor2 = Double.valueOf(this.mViewHolder.setValor.getText().toString());
            this.mViewHolder.setValor.setText(String.format("%.2f",valor1*valor1/valor2));
        }

//        int id = v.getId();
//        if (id == R.id.button_converter){
//            Double valor = Double.valueOf(this.mViewHolder.textoCalcular.getText().toString());
//            this.mViewHolder.setValor.setText(String.format("%.2f",valor*3.76));
//

    }

    private static class ViewHolder{
        Spinner getSpinner1;
        Spinner getSpinner2;
        ImageView getImage;
        Button btn_converter;
        EditText textoCalcular;
        TextView setValor;
        TextView teste;


    }


}
