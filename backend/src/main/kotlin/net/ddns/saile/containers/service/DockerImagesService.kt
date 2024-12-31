package net.ddns.saile.containers.service

import com.github.dockerjava.api.DockerClient
import com.github.dockerjava.api.async.ResultCallback
import com.github.dockerjava.api.command.PullImageCmd
import com.github.dockerjava.api.command.PullImageResultCallback
import com.github.dockerjava.api.model.Image
import com.github.dockerjava.api.model.PullResponseItem
import net.ddns.saile.containers.config.DockerConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DockerImagesService {
    @Autowired
    val dockerClient: DockerClient = DockerConfig().buildDockerClient();

    fun listImages():List<Image>{
        return dockerClient
            .listImagesCmd()
            .exec()
    }

    fun removeImage(imageId:String):Void{
        return dockerClient
            .removeImageCmd(imageId)
            .exec()
    }

    fun pullImage(image: String) {
        val pullImageCmd: PullImageCmd = dockerClient.pullImageCmd(image)
        
    }
}