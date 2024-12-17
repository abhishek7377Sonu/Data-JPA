package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.Repository.IMovieRepo;
import com.nt.model.Movie;
import com.nt.view.ResultView;
@Component
public class FinderMethodsTestRunner implements CommandLineRunner {
@Autowired
	private IMovieRepo repo;//InMemory proxy class obj of our proj will be injected
	@Override
	public void run(String... args) throws Exception {
	
		System.out.println("repository impl class name :"+repo.getClass());
		Iterable<ResultView>it=repo.findByMidGreaterThanEqualAndMidLessThanEqual(200,900);
		it.forEach(view->  {           
			System.out.println("Dynamic model class :"+view.getClass());
	                          System.out.println(view.getMid()+" "+view.getMname());                      
	                });
		
	}
}
