package service.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.role.RoleMapper;

import java.util.List;
import java.util.Map;

/**
 * @author: WangXinYu
 * @describe: TODO
 * @create: 2018年04月13日 10:30
 **/
@Service
public class RoleService {
    @Autowired
    RoleMapper roleMapper;
    public List<Map<String,Object>> listAllUserRole(){
        List<Map<String, Object>> mapList = roleMapper.listAllUser();
        return mapList;
    }

    public int updateUserRoleById(int id ,int role){
        int i = roleMapper.updateUserRoleByid(id, role);
        return i;
    }
    public Map<String,Object> getOneUser(String id){
        String leaderFlag = "";
        Map<String,Object> map = roleMapper.getOneUser(id);
        if(String.valueOf(map.get("d_leader")).equals(id)) {
            leaderFlag = "1";
        }else {
            leaderFlag = "2";
        }
        map.put("leaderFlag", leaderFlag);
        return map;
    }

    public int updateUserDepRole(String depId ,String userId){
        int i = roleMapper.updateUserDepRole(depId, userId);
        return i;
    }
}
