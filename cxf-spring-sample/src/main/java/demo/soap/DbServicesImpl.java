package demo.soap;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import demo.orm.dao.DataDao;
import demo.orm.entity.Database;
import demo.orm.entity.ResponseContainer;

@WebService(endpointInterface = "demo.soap.DbServices")
public class DbServicesImpl implements DbServices {

	@Autowired
	DataDao dataServices;

	@Override
	public ResponseContainer list(int count) {
		System.out.println("Request: list(" + Integer.toString(count) + ")");
		ResponseContainer resp = new ResponseContainer();

		try {
			List<Database> list = dataServices.getEntityList();
			for (int i = list.size(); i > count; i--) {
				list.remove(i - 1);
			}
			resp.setList(list);
		} catch (Exception e) {
			resp.setText(e.getMessage());
		}

		return resp;
	}

	@Override
	public ResponseContainer holy(String req) {
		System.out.println("Request: holy(\"" + req + "\")");
		ResponseContainer resp = new ResponseContainer();
		resp.setText("Holy" + req);
		return resp;
	}

}
