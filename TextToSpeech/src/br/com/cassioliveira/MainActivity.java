//package br.com.cassioliveira;
//
//import java.util.Locale;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.speech.tts.TextToSpeech;
//import android.speech.tts.TextToSpeech.OnInitListener;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//public class MainActivity extends Activity implements OnClickListener,
//		OnInitListener {
//
//	// Objeto do tipo TextToSpeech
//	private TextToSpeech myTTS;
//	// Código de checagem de status da Activity
//	private int MY_DATA_CHECK_CODE = 0;
//
//	// Cria a Activity
//	public void onCreate(Bundle savedInstanceState) {
//
//		super.onCreate(savedInstanceState);
////		setContentView(R.layout.main);
//
//		// Referencia para o botão do arquivo xml da interface
//		Button botaoFalar = (Button) findViewById(R.id.bt_fale);
//		// Monitora os cliques do botão
//		botaoFalar.setOnClickListener(this);
//
//		Intent checkTTSIntent = new Intent();
//		checkTTSIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
//		startActivityForResult(checkTTSIntent, MY_DATA_CHECK_CODE);
//	}
//
//	public void onClick(View v) {
//
//		// Captura o texto a ser falado
//		EditText enteredText = (EditText) findViewById(R.id.et_txt);
//		String textoCapturado = enteredText.getText().toString();
//		// Chama o método de fala
//		speakWords(textoCapturado);
//	}
//
//	// Método de fala
//	private void speakWords(String textoParaFalar) {
//		myTTS.speak(textoParaFalar, TextToSpeech.QUEUE_FLUSH, null);
//	}
//
//	// Checa a atividade do método de fala
//	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//
//		if (requestCode == MY_DATA_CHECK_CODE) {
//			if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
//				// Se o usuário tem os dados necessários para chamar o método de
//				// fala, uma instancia do Objeto de fala é criada
//				myTTS = new TextToSpeech(this, this);
//			} else {
//				Intent installTTSIntent = new Intent();
//				installTTSIntent
//						.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
//				startActivity(installTTSIntent);
//			}
//		}
//	}
//
//	// Método que verifica a região e define o idioma
//	public void onInit(int initStatus) {
//
//		// Checa se o idioma local está disponível no aparelho, senão utiliza o
//		// idioma inglês.
//		if (initStatus == TextToSpeech.SUCCESS) {
//			if (myTTS.isLanguageAvailable(Locale.US) == TextToSpeech.LANG_AVAILABLE)
//				myTTS.setLanguage(Locale.US);
//		} else if (initStatus == TextToSpeech.ERROR) {
//			Toast.makeText(this, "Desculpe! Falha ao falar o texto...",
//					Toast.LENGTH_LONG).show();
//		}
//	}
//}