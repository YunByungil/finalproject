package joa.review.model;

public class JoaLikeDTO {

	int lik_idx;
	String lik_movie_title;
	String lik_writer_id;
	String lik_like_id;
	
	public JoaLikeDTO() {
		// TODO Auto-generated constructor stub
	}

	public JoaLikeDTO(int lik_idx, String lik_movie_title, String lik_writer_id, String lik_like_id) {
		super();
		this.lik_idx = lik_idx;
		this.lik_movie_title = lik_movie_title;
		this.lik_writer_id = lik_writer_id;
		this.lik_like_id = lik_like_id;
	}

	public int getLik_idx() {
		return lik_idx;
	}

	public void setLik_idx(int lik_idx) {
		this.lik_idx = lik_idx;
	}

	public String getLik_movie_title() {
		return lik_movie_title;
	}

	public void setLik_movie_title(String lik_movie_title) {
		this.lik_movie_title = lik_movie_title;
	}

	public String getLik_writer_id() {
		return lik_writer_id;
	}

	public void setLik_writer_id(String lik_writer_id) {
		this.lik_writer_id = lik_writer_id;
	}

	public String getLik_like_id() {
		return lik_like_id;
	}

	public void setLik_like_id(String lik_like_id) {
		this.lik_like_id = lik_like_id;
	}
	
}
