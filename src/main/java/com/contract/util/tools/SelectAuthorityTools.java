package com.contract.util.tools;

import com.contract.mybatis.dao.AuthorityMapper;
import com.contract.mybatis.dao.RoleMapper;
import com.contract.mybatis.entity.Authority;
import com.contract.mybatis.entity.AuthorityExample;
import com.contract.mybatis.entity.Role;
import com.contract.mybatis.entity.RoleExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class SelectAuthorityTools {
    @Resource
    private AuthorityMapper authorityMapper;
    @Resource
    private RoleMapper roleMapper;

    public boolean selectAuthority(String num,String fun){
        AuthorityExample example1 = new AuthorityExample();
        example1.createCriteria().andUsernumEqualTo(num);

        List<Authority> entityList_1 = authorityMapper.selectByExample(example1);

        //没权限
        if (entityList_1!=null && !entityList_1.isEmpty()) {
            Authority authority = entityList_1.get(0);
            RoleExample example2 = new RoleExample();
            example2.createCriteria().andNameEqualTo(authority.getRolename());
            List<Role> entityList_2 = roleMapper.selectByExample(example2);
            Role role = entityList_2.get(0);
            String f = role.getFunctions();
            String[] ff = f.split("#");//?
            for (String subf : ff) {
                //有权限
                if (subf.equals(fun))
                    return true;
            }
        }
        return false;
    }
}
