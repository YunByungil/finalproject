package joa.adminMovie.model;

public class AdminMovieServiceImple implements AdminMovieService {
	
	private AdminMovieDAO adminMovieDao;

	public AdminMovieServiceImple(AdminMovieDAO adminMovieDao) {
		super();
		this.adminMovieDao = adminMovieDao;
	}

	@Override
	public int addMovie(AdminMovieDTO dto) {
		// TODO Auto-generated method stub
		int result=adminMovieDao.addMovie(dto);
		return result;
	}


}
