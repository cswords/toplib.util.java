package demo.soap;

import javax.jws.WebService;

import demo.orm.entity.ResponseContainer;

@WebService
public interface DbServices {

	public ResponseContainer list(int count);

	public ResponseContainer holy(String req);
}
