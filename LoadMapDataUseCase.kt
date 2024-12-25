class LoadMapDataUseCase(private val repository: MapRepository) {
    operator fun invoke(): Result<String> {
        return repository.getMapData()
    }
}