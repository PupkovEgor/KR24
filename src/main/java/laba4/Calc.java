package laba4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import laba4.Karkas;
import laba4.Napolnitel;
import laba4.Obivka;
import laba4.Vidstul;

@WebServlet(name="Calc", urlPatterns="/JavaCalc") //связывание сервлета с URL
public class Calc extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestCalc Calc = RequestCalc.fromRequestParameters(request);
		Calc.setAsRequestAttributesAndCalculate(request);
		request.getRequestDispatcher("/Results.jsp").forward(request, response);
	}
	
	private static class RequestCalc {
		private final String cenaKarkas;
		private final String cenaObivka;
		private final String cenaNapolnitel;
		private final String KolvoChair;
		private final String cenaOneChair;
		private final String check1;
		private final String vidStula2;
		private String result;
		private double result1;
		
		private String karkas1;
		private String stul1;
		private String obivka1;
		private String napolnitel1;
		
		private RequestCalc (String priceKarkas, 
				String priceObivka, String priceNapolnitel,String NumberChair, String priceForOneChair,String check,String VidStula) {
			this.cenaKarkas = priceKarkas;
			this.cenaObivka = priceObivka;
			this.cenaNapolnitel = priceNapolnitel;
			this.KolvoChair = NumberChair;
			this.cenaOneChair = priceForOneChair;
			this.vidStula2 = VidStula;
			if (check == null) {
				check1 = "Нет";
			} else {
				check1 = "Да";
			}
			}
		
		public static RequestCalc fromRequestParameters(HttpServletRequest request) {
			return new RequestCalc(
			request.getParameter("priceKarkas"),
			request.getParameter("priceObivka"),
			request.getParameter("priceNapolnitel"),
			request.getParameter("NumberChair"),
			request.getParameter("priceForOneChair"),
			request.getParameter("check"),
			request.getParameter("VidStula"));
			}
				
		public void setAsRequestAttributesAndCalculate(HttpServletRequest request) {
			request.setAttribute("first_result", cenaKarkas);
			request.setAttribute("second_result", cenaObivka);
			request.setAttribute("third_result", cenaNapolnitel);
			request.setAttribute("four_result", KolvoChair);
			request.setAttribute("five_result", cenaOneChair);
			request.setAttribute("checked", check1);
			
			Karkas Karkasmet = new Karkas(); Karkasmet.setPrice("500"); Karkasmet.setName("Металл");
			Karkas Karkasderev = new Karkas(); Karkasderev.setPrice("250"); Karkasderev.setName("Дерево");
			Karkas Karkasplastic = new Karkas(); Karkasplastic.setPrice("100"); Karkasplastic.setName("Пластик");
			if (cenaKarkas.equals(Karkasmet.getPrice())) { karkas1 = Karkasmet.getName();}
			if (cenaKarkas.equals(Karkasderev.getPrice())) { karkas1 = Karkasderev.getName();}
			if (cenaKarkas.equals(Karkasplastic.getPrice())) { karkas1 = Karkasplastic.getName();}
			
			Vidstul GameChair = new Vidstul(); GameChair.setPrice("3000"); GameChair.setName("Игровое кресло");
			Vidstul OfficeChair = new Vidstul(); OfficeChair.setPrice("2000"); OfficeChair.setName("Офисное кресло");
			Vidstul Pufik = new Vidstul(); Pufik.setPrice("500"); Pufik.setName("Пуфик");
			Vidstul KachalkaChair = new Vidstul(); KachalkaChair.setPrice("1500"); KachalkaChair.setName("Кресло-качалка");
			Vidstul MyagkiyChair = new Vidstul(); MyagkiyChair.setPrice("1000"); MyagkiyChair.setName("Стул с мягкой спинкой");
			if (vidStula2.equals(GameChair.getPrice())) { stul1 = GameChair.getName();}
			if (vidStula2.equals(OfficeChair.getPrice())) { stul1 = OfficeChair.getName();}
			if (vidStula2.equals(Pufik.getPrice())) { stul1 = Pufik.getName();}
			if (vidStula2.equals(KachalkaChair.getPrice())) { stul1 = KachalkaChair.getName();}
			if (vidStula2.equals(MyagkiyChair.getPrice())) { stul1 = MyagkiyChair.getName();}
			
			Obivka IskKoja = new Obivka();IskKoja.setPrice("500"); IskKoja.setName("Искусственная кожа");
			Obivka EcoKoja = new Obivka();EcoKoja.setPrice("800"); EcoKoja.setName("Эко-кожа");
			Obivka Tkan = new Obivka();Tkan.setPrice("550"); Tkan.setName("Ткань");
			Obivka Zamcha = new Obivka();Zamcha.setPrice("1800"); Zamcha.setName("Замша");
			Obivka Velvet = new Obivka();Velvet.setPrice("830"); Velvet.setName("Вельвет");
			if (cenaObivka.equals(IskKoja.getPrice())) { obivka1 = IskKoja.getName();}
			if (cenaObivka.equals(EcoKoja.getPrice())) { obivka1 = EcoKoja.getName();}
			if (cenaObivka.equals(Tkan.getPrice())) { obivka1 = Tkan.getName();}
			if (cenaObivka.equals(Zamcha.getPrice())) { obivka1 = Zamcha.getName();}
			if (cenaObivka.equals(Velvet.getPrice())) { obivka1 = Velvet.getName();}
			
			Napolnitel Porolon = new Napolnitel();Porolon.setPrice("400"); Porolon.setName("Поролон");
			Napolnitel Sintepon = new Napolnitel();Sintepon.setPrice("130"); Sintepon.setName("Синтепон");
			Napolnitel Voylok = new Napolnitel();Voylok.setPrice("2700"); Voylok.setName("Войлок");
			if (cenaNapolnitel.equals(Porolon.getPrice())) { napolnitel1 = Porolon.getName();}
			if (cenaNapolnitel.equals(Sintepon.getPrice())) { napolnitel1 = Sintepon.getName();}
			if (cenaNapolnitel.equals(Voylok.getPrice())) { napolnitel1 = Voylok.getName();}
			
			request.setAttribute("karkas_result", karkas1);
			request.setAttribute("vidstula_result", stul1);
			request.setAttribute("obivka_result", obivka1);
			request.setAttribute("napolnitel_result", napolnitel1);
			
			
			double Kark=0;
			double Obiv=0;
			double Napoln=0;
			double Kolvo=0;
			double PriceOne=0;
			double CenaObivki=0;
			try {
				Kark=Double.parseDouble(cenaKarkas);
				Obiv=Double.parseDouble(cenaObivka);
				Napoln=Double.parseDouble(cenaNapolnitel);
				Kolvo=Double.parseDouble(KolvoChair);
				PriceOne=Double.parseDouble(cenaOneChair);
			}
			catch (Exception e) {
				Kark = 0;
				Obiv = 0;
				Napoln = 0;
				Kolvo = 0;
				PriceOne = 0;
			}
				CenaObivki = Obiv+Napoln;
			result1=(Kark+CenaObivki+PriceOne)*Kolvo;
			result = "" + result1;
			request.setAttribute("result", result);
		}
		
	}
}
