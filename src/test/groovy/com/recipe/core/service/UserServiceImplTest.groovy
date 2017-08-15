package com.recipe.core.service
import spock.lang.Specification
import com.recipe.core.repository.*
import spock.lang.Unroll
/**
 * Created by 1NM30 on 14/08/2017.
 */
class UserServiceImplTest extends Specification{
    UserService userService = new UserServiceImpl()

    @Unroll("Get users #_usersMock")
        def "Get Users"() {
            given:"Dado lo siguiente"
                def users
                def usersMock = _usersMock
            and:"y"
                def userDaoMock = Mock(UserDao)
                userService.userDao = userDaoMock
            when:"cuando"
                users = userService.getUsers()
            then:"entonces"
                1 * userDaoMock.findAll() >> usersMock
                assert users.size() > 0
            where:"donde"
                _usersMock << [
                        [new UserEntity(id: 1, name: "nombre 1",
                                password: "contraseña 1")],
                        [new UserEntity(id: 2, name: "nombre 2",
                                password: "contraseña 2")]
                ]
        }
}
