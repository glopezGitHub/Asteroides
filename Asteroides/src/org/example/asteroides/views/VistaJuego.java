package org.example.asteroides.views;

public class VistaJuego {

	
	 // //// ASTEROIDES //////

//    private Vector<Grafico> Asteroides; // Vector con los Asteroides
//
//    private int numAsteroides= 5; // N�mero inicial de asteroides
//
//    private int numFragmentos= 3; // Fragmentos en que se divide

//    public VistaJuego(Context context, AttributeSet attrs) {
//
//          super(context, attrs);
//
//          Drawable drawableNave, drawableAsteroide, drawableMisil;
//
//          drawableAsteroide = context.getResources().getDrawable(
//                                                                                R.drawable.asteroide1);
//
//          Asteroides = new Vector<Grafico>();
//
//          for (int i = 0; i < numAsteroides; i++) {
//
//                Grafico asteroide = new Grafico(this, drawableAsteroide);
//
//                asteroide.setIncY(Math.random() * 4 - 2);
//
//                asteroide.setIncX(Math.random() * 4 - 2);
//
//                asteroide.setAngulo((int) (Math.random() * 360));
//
//                asteroide.setRotacion((int) (Math.random() * 8 - 4));
//
//                Asteroides.add(asteroide);
//
//          }
//
//    }
//
//
//
//    @Override protected void onSizeChanged(int ancho, int alto,
//                                                         int ancho_anter, int alto_anter) {
//
//          super.onSizeChanged(ancho, alto, ancho_anter, alto_anter);
//
//          // Una vez que conocemos nuestro ancho y alto.
//
//          for (Grafico asteroide: Asteroides) {
//
//                asteroide.setPosX(Math.random()*
//                                                                     (ancho-asteroide.getAncho()));
//
//                asteroide.setPosY(Math.random()*
//                                                                     (alto-asteroide.getAlto()));
//
//          }
//
//    }
//
//
//
//    @Override protected void onDraw(Canvas canvas) {
//
//          super.onDraw(canvas);
//
//          for (Grafico asteroide: Asteroides) {
//
//              asteroide.dibujaGrafico(canvas);
//
//          }
//
//    }
}
