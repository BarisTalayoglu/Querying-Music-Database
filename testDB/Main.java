package testDB;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		Datasource datasource = new Datasource();
		if(!datasource.open()) {
			System.out.println("Cant open datasource");
			return;
		}
		
		List<Artist> artists = datasource.queryArtists();
		
		if(artists == null) {
			System.out.println("No artists");
			return;
		}
		
		for(Artist artist : artists) {
			System.out.println("ID: "+ artist.getId()+ ", Name: "+ artist.getName());
			
		}

		
		/*List<String> albumsForArtist = 
				datasource.queryAlbumsForArtist("Pink Floyd", Datasource.ORDER_BY_ASC);
		
		for(String album: albumsForArtist) {
			System.out.println(album);
		}
		
		
		List<SongArtist> songArtists = datasource.queryArtistsForSong("Heartless", Datasource.ORDER_BY_ASC);
		if(songArtists == null) {
			System.out.println("Can't find the artist for the song");
			return;
		}
		
		for(SongArtist artist : songArtists) {
			System.out.println("Name: "+ artist.getAlbumName() +", Album: "+artist.getArtistName() + ", Track: "+artist.getTrack());
			
		}
		*/
		
		int count = datasource.getCount(Datasource.TABLE_SONGS);
		System.out.println("Total count of songs: " + count);
		
		
		datasource.close();
		
	}

}
