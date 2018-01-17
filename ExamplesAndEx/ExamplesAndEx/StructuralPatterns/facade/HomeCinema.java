package facade;
class HomeCinemaFacade {
	Dvdplayer m_dvd;
	Speakers m_speakers;


	HomeCinemaFacade (Dvdplayer d, Speakers s) {
		m_dvd = d;
		m_speakers = s;
	
	}
	
	public void playMovie() {
		m_speakers.amplify();
		m_dvd.play();
	}

}



class Dvdplayer {
	public void play() {
	System.out.println("Dvdplayer...");
	
	}

}


class Speakers {

	public void amplify(){
	System.out.println("speakers...");
	}

}


class Main {
	public static void main (String args[]) {
		Dvdplayer d = new Dvdplayer();
		Speakers s = new Speakers();
		
		s.amplify();
		d.play();
		
		HomeCinemaFacade facade = new HomeCinemaFacade(d,s);
		facade.playMovie();
	}

}