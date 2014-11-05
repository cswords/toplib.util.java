package demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.orm.dao.DataDao;
import demo.orm.entity.Database;
import demo.orm.entity.ResponseContainer;

@Controller
@RequestMapping("/Db")
public class DbController {

	@Autowired
	DataDao dataServices;

	@RequestMapping(value = "/{count}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public @ResponseBody ResponseContainer list(@PathVariable("count") int count) {
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
}
