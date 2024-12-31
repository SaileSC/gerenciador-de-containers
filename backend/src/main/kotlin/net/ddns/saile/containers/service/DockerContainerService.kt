package net.ddns.saile.containers.service

import com.github.dockerjava.api.DockerClient
import com.github.dockerjava.api.command.CreateContainerResponse
import com.github.dockerjava.api.model.Container
import net.ddns.saile.containers.config.DockerConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DockerContainerService {
    @Autowired
    val dockerClient: DockerClient = DockerConfig().buildDockerClient();

    fun listContainers(all: Boolean):List<Container>{
        return dockerClient
            .listContainersCmd()
            .withShowAll(all)
            .exec();
    }

    fun crateContainer(image:String, name:String):CreateContainerResponse{
        return dockerClient
            .createContainerCmd(image)
            .withName(name)
            .exec();
    }

    fun deleteContainer(containerId:String):Void{
        return dockerClient
            .removeContainerCmd(containerId)
            .exec();
    }

    fun startContainer(containerId: String):Void{
        return dockerClient
            .startContainerCmd(containerId)
            .exec()
    }

    fun stopContainer(containerId:String):Void{
        return dockerClient
            .stopContainerCmd(containerId)
            .exec()
    }
}