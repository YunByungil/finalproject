package joa.movie.model;

import java.util.*;

public interface JoaMovieDAO {

	public List<JoaMovieDTO> movieList(int ot);
	public List<JoaMovieDTO> preMovieDate();
	public List<JoaMovieDTO> preMovieList();
	public List<JoaMovieDTO> detailView(int mov_idx);
}
