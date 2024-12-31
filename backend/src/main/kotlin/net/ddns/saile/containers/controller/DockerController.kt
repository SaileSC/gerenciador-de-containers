package net.ddns.saile.containers.controller

import com.github.dockerjava.api.model.Container
import net.ddns.saile.containers.service.DockerContainerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api")
class DockerController {
    @Autowired
    var dockerService:DockerContainerService = DockerContainerService()

    @GetMapping
    fun list():ResponseEntity<List<Container>>{
        val containers:List<Container> =  dockerService.listContainers(true)
        return ResponseEntity.ok().body(containers);
    }


}