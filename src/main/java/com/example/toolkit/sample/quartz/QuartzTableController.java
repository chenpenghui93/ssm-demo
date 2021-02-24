package com.example.toolkit.sample.quartz;

import com.example.toolkit.mapper.QuartzConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chenpenghui
 * @date 2021-2-24
 */
@Controller
public class QuartzTableController {

    @Resource
    private QuartzTableService quartzTableService;

    @Autowired
    private QuartzConfigMapper quartzConfigMapper;

    @GetMapping("/table")
    public String table(ModelMap map) {
        List<QuartzConfig> configs = quartzConfigMapper.selectList(null);
        for (QuartzConfig config : configs) {
            String message = ConfigEnum.findByMessage(config.getStatus());
            config.setStatus(message);
        }
        map.put("configs", configs);
        return "/table";
    }

    @PostMapping("/updateStatus")
    public Result updateStatus(Long id, String status) {
        Result result = new Result();
        result.setResult(false);
        try {
            quartzTableService.update(id, status);
            result.setResult(true);
        } catch (Exception e) {
            result.setMsg(e.toString());
        }
        return result;
    }


}
