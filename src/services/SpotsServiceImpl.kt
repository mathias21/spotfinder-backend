package dev.remylavergne.spotfinder.services

import dev.remylavergne.spotfinder.controllers.dto.SpotCreationDto
import dev.remylavergne.spotfinder.data.models.Spot
import dev.remylavergne.spotfinder.repositories.SpotsRepository

class SpotsServiceImpl(private val spotsRepository: SpotsRepository) : SpotsService {

    override fun createNewSpot(dto: SpotCreationDto): String {
        // Create a real spot object
        val spot = Spot.fromCreationDto(dto)
        // Save spot into database
        val result = spotsRepository.persistSpot(spot)
        return if (result) { // TODO: Sealed class for Service State status
            "Success"
        } else {
            "Error"
        }
    }
}
