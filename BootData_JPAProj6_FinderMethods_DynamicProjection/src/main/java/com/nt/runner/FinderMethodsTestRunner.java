package com.nt.runner;

import java.util.List;

import org.hibernate.property.access.spi.GetterMethodImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.Repository.IMovieRepo;
import com.nt.model.Movie;
//import com.nt.view.ResultView;
import com.nt.view.ResultView1;
import com.nt.view.ResultView2;
import com.nt.view.ResultView3;
import com.nt.view.View;

@Component
public class FinderMethodsTestRunner implements CommandLineRunner {
	@Autowired
	private IMovieRepo repo;// InMemory proxy class obj of our proj will be injected

	@Override
	public void run(String... args) throws Exception {
		/*
		Iterable<ResultView1> list = repo.findByMnameIn(List.of("RRR", "KGF"), ResultView1.class);
		list.forEach(v1 -> {
			System.out.println(v1.getMid() + "   " + v1.getMname());
		});

		System.out.println("==================================");
		Iterable<ResultView2> list1 = repo.findByMnameIn(List.of("RRR", "KGF"), ResultView2.class);
		repo.findByMnameIn(List.of("RRR", "KGF"), ResultView2.class);
		list1.forEach(v2 -> {
			System.out.println(v2.getMid() + "   " + v2.getMname() + " " + v2.getRating());
		});

		System.out.println("==================================");

		Iterable<ResultView3> list2 = repo.findByMnameIn(List.of("RRR", "KGF"), ResultView3.class);
		repo.findByMnameIn(List.of("RRR", "KGF"), ResultView3.class);
		list.forEach(v3 -> {
			System.out.println(v3.getMid() + "   " + v3.getMname() + " " + v3.getYear());
		});
		
		*/
		
		Movie movie=new Movie();
		movie.setMname("Tillu");
      movie.setRating(7.3f);
		movie.setYear("2024");
	System.out.println(repo.save(movie).getMid()+" object is saved ");
		
		
		
	}
}
