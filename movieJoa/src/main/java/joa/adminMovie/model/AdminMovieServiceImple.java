package joa.adminMovie.model;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminMovieServiceImple implements AdminMovieService {
	
	private AdminMovieDAO adminMovieDao;

	public AdminMovieServiceImple(AdminMovieDAO adminMovieDao) {
		super();
		this.adminMovieDao = adminMovieDao;
	}

	@Override
	public int addMovie(AdminMovieDTO dto) {
		// TODO Auto-generated method stub
		
		Map map=new HashMap();
		
		map.put("title", dto.getMov_title());
		map.put("director", dto.getMov_director());
		map.put("cast", dto.getMov_cast());
		map.put("start_date", dto.getMov_start_date());
		map.put("end_date", dto.getMov_end_date());
		map.put("country", dto.getMov_country());
		map.put("genre", dto.getMov_genre());
		map.put("running_time", dto.getMov_running_time());
		map.put("rate", dto.getMov_rate());
		map.put("info", dto.getMov_info());
		map.put("poster", dto.getMov_poster());
		
		int result=adminMovieDao.addMovie(map);
		return result;
	}

	@Override
	public int updateMovie(AdminMovieDTO dto) {
		// TODO Auto-generated method stub
		Map map=new HashMap();
		
		map.put("idx", dto.getMov_idx());
		map.put("title", dto.getMov_title());
		map.put("director", dto.getMov_director());
		map.put("cast", dto.getMov_cast());
		map.put("start_date", dto.getMov_start_date());
		map.put("end_date", dto.getMov_end_date());
		map.put("country", dto.getMov_country());
		map.put("genre", dto.getMov_genre());
		map.put("running_time", dto.getMov_running_time());
		map.put("rate", dto.getMov_rate());
		map.put("info", dto.getMov_info());
		map.put("poster", dto.getMov_poster());
		
		int result=adminMovieDao.updateMovie(map);
		
		System.out.println("service단 result:"+result);
		return result;
	}

	@Override
	public AdminMovieDTO detailMovie(int mov_idx) {
		AdminMovieDTO dto=adminMovieDao.detailMovie(mov_idx);
		return dto;
	}

	@Override
	public List listMovie(int cp, int ls) {
		int start=(cp-1)*ls+1;
		int end=cp*ls;
		Map map=new HashMap();
		map.put("start", start);
		System.out.println(start);
		map.put("end", end);
		System.out.println(end);
		List list=adminMovieDao.listMovie(map);
		System.out.println(list);
		return list;
	}

	@Override
	public int adminMovieTotalCnt() {
		int result=adminMovieDao.adminMovieTotalCnt();
		return result;
	}

	@Override
	public int deleteMovie(int mov_idx) {
		// TODO Auto-generated method stub
		int result=adminMovieDao.deteleMovie(mov_idx);
		return result;
	}

	@Override
	public List searchMovie(String sc_t, String sc_k) {
		// TODO Auto-generated method stub
		Map map=new HashMap();
		map.put("sc_t", sc_t);
		map.put("sc_k", sc_k);
		List list=adminMovieDao.searchMovie(map);
		return list;
	}


}
