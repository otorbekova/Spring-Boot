package com.my.SpringSecutity.SpringRest.ServerApi;

import com.my.SpringSecutity.SpringRest.Error.ErrorMessage;
import com.my.SpringSecutity.SpringRest.Error.ErrorValid;
import com.my.SpringSecutity.SpringRest.RepositoryApi.RepositoryModel;
import com.my.SpringSecutity.models.UserModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
//@ResponseBody
public class ServerApiRest {
    private final RepositoryModel repositoryModel;
@Autowired
    public ServerApiRest(RepositoryModel repositoryModel) {
        this.repositoryModel = repositoryModel;

    }

   // @Transactional
    public List<UserModels> findAll(){
        return repositoryModel.findAll();
    }

    public UserModels findId(int id){
        Optional<UserModels> option=repositoryModel.findById(id);
    return option.orElseThrow(ErrorValid::new);
    }

    @Transactional
    public void save(UserModels models){
    repositoryModel.save(models);
    }
}
