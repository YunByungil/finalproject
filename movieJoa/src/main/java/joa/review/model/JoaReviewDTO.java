package joa.review.model;

public class JoaReviewDTO {

   int rev_idx;
   String rev_id;
   String rev_movie_title;
   String rev_comment;
   int rev_score;
   String rev_date;
   int rev_like;
   
   public JoaReviewDTO() {
      // TODO Auto-generated constructor stub
   }

   public JoaReviewDTO(int rev_idx, String rev_id, String rev_movie_title, String rev_comment, int rev_score,
         String rev_date, int rev_like) {
      super();
      this.rev_idx = rev_idx;
      this.rev_id = rev_id;
      this.rev_movie_title = rev_movie_title;
      this.rev_comment = rev_comment;
      this.rev_score = rev_score;
      this.rev_date = rev_date;
      this.rev_like = rev_like;
   }

   public int getRev_idx() {
      return rev_idx;
   }

   public void setRev_idx(int rev_idx) {
      this.rev_idx = rev_idx;
   }

   public String getRev_id() {
      return rev_id;
   }

   public void setRev_id(String rev_id) {
      this.rev_id = rev_id;
   }

   public String getRev_movie_title() {
      return rev_movie_title;
   }

   public void setRev_movie_title(String rev_movie_title) {
      this.rev_movie_title = rev_movie_title;
   }

   public String getRev_comment() {
      return rev_comment;
   }

   public void setRev_comment(String rev_comment) {
      this.rev_comment = rev_comment;
   }

   public float getRev_score() {
      return rev_score;
   }

   public void setRev_score(int rev_score) {
      this.rev_score = rev_score;
   }

   public String getRev_date() {
      return rev_date;
   }

   public void setRev_date(String rev_date) {
      this.rev_date = rev_date;
   }

   public int getRev_like() {
      return rev_like;
   }

   public void setRev_like(int rev_like) {
      this.rev_like = rev_like;
   }
   
}