package com.example.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.Announce;



@Repository
public interface AnnonceRepository extends JpaRepository<Announce, Integer>{

	

	@Query(value="Select r from Announce r  where r.nbrchambre >= :NbrchambreMin and r.type = :type and  r.regions = :region")
    public List<Announce> findReservationBynbrChambre(@Param("NbrchambreMin")int NbrchambreMin,@Param("type")String type ,@Param("region")String region);

	@Query(value="Select r from Announce r  where r.price >= :priceMin and r.price<= :priceMax and r.type = :type and  r.regions = :region ")
    public List<Announce> findReservationBynbyprice(@Param("priceMin")float priceMin,@Param("priceMax")float priceMax,@Param("type")String type ,@Param("region")String region);

	@Query(value="Select r from Announce r  where r.type = :type and  r.regions = :region")
	public List<Announce> findReservationByRegion(@Param("type")String type ,@Param("region")String region );

	@Query(value="Select a from Announce a where a.type = :type and  a.regions = :region and a.id Not IN (Select r.announce from Reservation r where    ((r.checkIn<= :checkIn and r.checkOut>= :checkIn) or (r.checkIn<= :checkOut and r.checkOut>= :checkOut) or (r.checkIn<= :checkIn and r.checkOut>= :checkIn and r.checkIn<= :checkOut and r.checkOut>= :checkOut) or (r.checkIn>= :checkIn and r.checkOut>= :checkIn and r.checkIn<= :checkOut and r.checkOut<= :checkOut) ))")
	public List<Announce> findbyDate(@Param("checkIn")Date checkIn, @Param("checkOut")Date checkOut,@Param("type")String type ,@Param("region")String region);
	
	@Query(value="Select a from Announce a where a.price >= :priceMin and a.price<= :priceMax and a.type = :type and  a.regions = :region and a.id Not IN (Select r.announce from Reservation r where  ((r.checkIn<= :checkIn and r.checkOut>= :checkIn) or (r.checkIn<= :checkOut and r.checkOut>= :checkOut) or (r.checkIn<= :checkIn and r.checkOut>= :checkIn and r.checkIn<= :checkOut and r.checkOut>= :checkOut) or (r.checkIn>= :checkIn and r.checkOut>= :checkIn and r.checkIn<= :checkOut and r.checkOut<= :checkOut) ))")
	public List<Announce> findbyDatep(@Param("priceMin")float priceMin,@Param("priceMax")float priceMax,@Param("checkIn")Date checkIn, @Param("checkOut")Date checkOut,@Param("type")String type ,@Param("region")String region);
	
	@Query(value="Select a from Announce a where a.nbrchambre >= :NbrchambreMin and a.price >= :priceMin and a.price<= :priceMax and a.type = :type and  a.regions = :region and a.id Not IN (Select r.announce from Reservation r where    ((r.checkIn<= :checkIn and r.checkOut>= :checkIn) or (r.checkIn<= :checkOut and r.checkOut>= :checkOut) or (r.checkIn<= :checkIn and r.checkOut>= :checkIn and r.checkIn<= :checkOut and r.checkOut>= :checkOut) or (r.checkIn>= :checkIn and r.checkOut>= :checkIn and r.checkIn<= :checkOut and r.checkOut<= :checkOut) ))")
	public List<Announce> findbyDatepc(@Param("NbrchambreMin")int NbrchambreMin,@Param("priceMin")float priceMin,@Param("priceMax")float priceMax,@Param("checkIn")Date checkIn, @Param("checkOut")Date checkOut,@Param("type")String type ,@Param("region")String region);
	
	@Query(value="Select a from Announce a where a.nbrchambre >= :NbrchambreMin and a.type = :type and  a.regions = :region and a.id Not IN (Select r.announce from Reservation r where    ((r.checkIn<= :checkIn and r.checkOut>= :checkIn) or (r.checkIn<= :checkOut and r.checkOut>= :checkOut) or (r.checkIn<= :checkIn and r.checkOut>= :checkIn and r.checkIn<= :checkOut and r.checkOut>= :checkOut)or(r.checkIn>= :checkIn and r.checkOut>= :checkIn and r.checkIn<= :checkOut and r.checkOut<= :checkOut) ))")
	public List<Announce> findbyDatec(@Param("NbrchambreMin")int NbrchambreMin,@Param("checkIn")Date checkIn, @Param("checkOut")Date checkOut,@Param("type")String type ,@Param("region")String region);
	
	@Query(value="Select r from Announce r  where r.nbrchambre >= :NbrchambreMin and r.price >= :priceMin and r.price<= :priceMax and r.type = :type and  r.regions = :region ")
    public List<Announce> findReservationBynbypricec(@Param("NbrchambreMin")int NbrchambreMin,@Param("priceMin")float priceMin,@Param("priceMax")float priceMax,@Param("type")String type ,@Param("region")String region);

	@Query(value="Select a from Announce  a where a.user.userName= :userName ")
    public List<Announce> findAnnounceByUser(@Param("userName")String userName);
	
	@Query(value="Select a from Announce  a where a.id= :id ")
    public List<Announce> findAnnounceByid(@Param("id")int id);

	


	}
		