package com.userapp.processors;

import com.userapp.model.context.UserContext;
import com.userapp.model.context.UserPageContext;
import com.userapp.model.context.UserViewContext;
import com.userapp.model.entity.AppUser;
import com.userapp.respository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component("step.user.findAll")
public class UserFindAllProcessor implements ProcessorStep<UserContext> {
    private final AppUserRepository repository;

    @Override
    public void execute(UserContext ctx) {
        if (!ctx.isSuccess()) return;
        UserPageContext pageCtx = (UserPageContext) ctx;
        PageRequest pageable = PageRequest.of(
                pageCtx.getPage(),
                pageCtx.getSize()
        );
        Page<AppUser> page = repository.findAll(pageable);
        List<UserViewContext> users = page.getContent().stream()
                .map(user -> UserViewContext.builder()
                        .id(user.getId())
                        .firstName(user.getFirstName())
                        .lastName(user.getLastName())
                        .email(user.getEmail())
                        .status(user.getStatus())
                        .build()
                )
                .toList();
        pageCtx.setUsers(users);
        pageCtx.setTotalElements(page.getTotalElements());
    }
}
